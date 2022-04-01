从源码构建的redex工具
依赖的版本
autoconf: 2.71
python: 3.8.13
automake: 1.16.3
libtool: 2.4.7
boost: 1.78.0
jsoncpp: 1.9.5

brew install autoconf automake libtool
brew install boost jsoncpp
brew install protobuf

注意automake 要降级为1.16.3
https://github.com/facebook/redex/issues/644


git clone https://github.com/facebook/redex.git
cd redex
git checkout stable (commit ef6b7bac51c2008f99cb032a0091573c29563402)
代码切换到了stable分支

autoreconf -ivf && ./configure && make -j4

编译了大概2小时.

sudo make install
