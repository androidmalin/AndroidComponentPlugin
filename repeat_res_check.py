# -*- coding: utf-8 -*-
# !/usr/bin/env python
"""
-------------------------------------------------
   File     : repeat_res_check.py
   Author   : CoderPig
   date     : 2021-11-04 17:28
   Desc     : 重复资源检索脚本
   request  : python3
-------------------------------------------------
"""
import os
import threading as t
import hashlib

search_path = os.getcwd()  # 待分析目录，默认脚本所有路径，可自行写死

# 输出文件，依次为：名字重复、md5重复
name_repeat_result_file = os.path.join(os.getcwd(), "name_repeat_result.txt")
md5_repeat_result_file = os.path.join(os.getcwd(), "md5_repeat_result.txt")

# 暂存结果
res_list = []  # 资源文件列表
name_repeat_dict = {}
md5_repeat_dict = {}

# 资源后缀元组 (按需自己加)
res_suffix_tuple = ('.xml', '.jpg', '.png', '.webp', '.JPG', '.PNG', '.svg', '.SVG', '.webp', '.py')

# 排除目录列表或文件 (按需自己加)
exclude_dir_list = ["build{}".format(os.path.sep),
                    ".idea{}".format(os.path.sep),
                    "AndroidManifest.xml"]

# 文件读写锁
lock = t.RLock()


# 检索所有资源文件
def search_all_res_files(path):
    os.chdir(path)
    items = os.listdir(os.curdir)
    for item in items:
        path = os.path.join(item)
        # 获取路径分割后的最后部分，即文件名
        file_name = path.split(os.path.sep)[-1]
        absolute_path = "{}{}{}".format(os.getcwd(), os.path.sep, path)
        # 判断是否为目录，是往下递归
        if os.path.isdir(path):
            print("[-]", absolute_path)
            search_all_res_files(path)
            os.chdir(os.pardir)
        # 只检测资源文件
        elif file_name.endswith(res_suffix_tuple):
            print("[!]", absolute_path)
            res_list.append(absolute_path)
        else:
            print("[+]", absolute_path)


# 分析名字重复资源文件
def analysis_repeat_name_files():
    print("分析名字重复文件...")
    for res in res_list:
        if not any(name in res for name in exclude_dir_list):
            res_file_name = res.split(os.path.sep)[-1]
            file_md5 = get_file_md5(res)
            if name_repeat_dict.get(res_file_name) is None:
                name_repeat_dict[res_file_name] = ["{} → {}".format(file_md5, res)]
            else:
                name_repeat_dict[res_file_name].append("{} → {}".format(file_md5, res))
    if len(name_repeat_dict.keys()) == 0:
        print("未检测到名字重复资源...")
    else:
        format_output(name_repeat_dict, "名字重复", name_repeat_result_file)


# 分析md5重复资源文件
def analysis_repeat_md5_files():
    print("分析md5重复文件...")
    for res in res_list:
        if not any(name in res for name in exclude_dir_list):
            file_md5 = get_file_md5(res)
            if md5_repeat_dict.get(file_md5) is None:
                md5_repeat_dict[file_md5] = {res}
            else:
                md5_repeat_dict[file_md5].add(res)
    if len(name_repeat_dict.keys()) == 0:
        print("未检测到md5重复资源...")
    else:
        format_output(md5_repeat_dict, "md5重复", md5_repeat_result_file)


# 格式化输出
def format_output(origin_dict, hint, result_file):
    print("生成{}分析结果...".format(hint))
    output_content = ''
    if len(origin_dict.keys()) == 0:
        output_content += "未检测到{}资源...".format(hint)
    else:
        output_content = "共检索到资源文件：【{}】个\n共检索到{}资源文件：【{}】个\n\n"
        repeat_file_count = 0
        for (k, v) in origin_dict.items():
            if len(v) > 1:
                repeat_file_count += 1
                output_content += "{} {} {}\n".format('=' * 18, k, '=' * 18)
                for value in v:
                    output_content += "{}\n".format(value)
                output_content += "\n\n"
        output_content = output_content.format(len(res_list), hint, repeat_file_count)
        write_str_data(output_content, result_file)


# 获取文件md5
def get_file_md5(file_name):
    m = hashlib.md5()
    try:
        with lock:
            with open(file_name, 'rb') as f:
                while True:
                    data = f.read(4096)
                    if not data:
                        break
                    m.update(data)
            return m.hexdigest()
    except OSError as reason:
        print(str(reason))


# 把内容写入文件
def write_str_data(content, file_path):
    with lock:
        try:
            with open(file_path, "w+", encoding='utf-8') as f:
                f.write(content + "\n", )
                print("输出结果文件：{}\n".format(file_path))
        except OSError as reason:
            print(str(reason))


if __name__ == '__main__':
    print("当前检索目录：{}".format(search_path))
    search_all_res_files(search_path)
    print("\n资源文件检索完毕，开始进行分析...\n")
    if len(res_list) == 0:
        print("未检测到资源文件")
    else:
        analysis_repeat_name_files()
        analysis_repeat_md5_files()