### Android 启动未在AndroidManifest.xml中注册的Activity

0. 支持2种方式.第一种,hook Instrument实现;第二种,hook Handler实现.

1. 兼容android4.1 ~ android12

2. kotlin 实现

3. 增加了代码混淆配置

4. 使用最新gradle,apg版本

5. 采用gradle kotlin dsl

### 测试代码为 develop_kotlin分支, 代码兼容 android 4.1 到 android 12
### wetest设备兼容测试情况如下:
### 测试设备数量313, 通过309(98.7%), 4台未通过

| 设备品牌     | 设备型号                    | 设备别名               | 系统版本    |通过|
|:-:         |:-:                         |:-:                    |:-:       |:-:|
| Google     | Pixel 5                    | PIXEL 5             | 12    |  ✅  |
| GOOGLE     | Pixel 4                    | PIXEL 4             | 11    |  ✅  |
| GOOGLE     | Pixel 5                    | PIXEL 5             | 11    |  ✅  |
| ONEPLUS    | HD1910                     | OnePlus 7T          | 11    |  ✅  |
| ONEPLUS    | IN2010                     | 一加8                 | 11    |  ✅  |
| ONEPLUS    | LE2110                     | 一加9                 | 11    |  ✅  |
| OPPO       | PDEM30                     | Find X2 Pro         | 11    |  ✅  |
| OPPO       | PDPM00                     | oppo Reno4 5G       | 11    |  ✅  |
| OPPO       | PEGT00                     | Reno 5              | 11    |  ✅  |
| OnePlus    | IN2020                     | 8 Pro               | 11    |  ✅  |
| OnePlus    | KB2000                     | OnePlus 8T 5G       | 11    |  ✅  |
| REALME     | RMX3041                    | realme V13          | 11    |  ✅  |
| REALME     | RMX3121                    | realmeV11           | 11    |  ✅  |
| SAMSUNG    | SM-G9730                   | Galaxy S10          | 11    |  ✅  |
| SAMSUNG    | SM-G9880                   | Galaxy S20 Ultra 5G | 11    |  ✅  |
| SAMSUNG    | SM-N9760                   | SM-N9760            | 11    |  ✅  |
| XIAOMI     | M2102J2SC                  | 小米10S               | 11    |  ✅  |
| XIAOMI     | M2102K1AC                  | 小米11 Pro            | 11    |  ✅  |
| Xiaomi     | M2011K2C                   | 小米11 5G             | 11    |  ✅  |
| Xiaomi     | M2012K11AC                 | 红米 K40              | 11    |  ✅  |
| Xiaomi     | Redmi K30 Pro Zoom Edition | K30 Pro             | 11    |  ✅  |
| realme     | RMX2202                    | realme GT           | 11    |  ✅  |
| samsung    | SM-G9860                   | 三星Galaxy S20+ 5G    | 11    |  ✅  |
| vivo       | V1824BA                    | VIVO iQOO           | 11    |  ✅  |
| vivo       | V1916A                     | VIVO iQOO Pro 5G    | 11    |  ✅  |
| vivo       | V1986A                     | VIVO iQOO Z1        | 11    |  ✅  |
| vivo       | V2054A                     | iQOO                | 11    |  ✅  |
| ASUS       | ASUS_I003DD                | ROG Phone 3         | 10    |  ✅  |
| BLACKSHARK | SHARK MBU-A0               | 游戏手机3 Pro         | 10    |  ✅  |
| GOOGLE     | Pixel 2 XL                 | 2 XL                | 10    |  ✅  |
| GOOGLE     | Pixel 3a                   | Pixel 3A            | 10    |  ✅  |
| GOOGLE     | Pixel 4 XL                 | PIXEL 4 XL          | 10    |  ✅  |
| HONOR      | YOK-AN10                   | 荣耀V40               | 10    |  ✅  |
| HUAWEI     | AKA-AL10                   | 荣耀Play4T            | 10    |  ✅  |
| HUAWEI     | ALP-TL00                   | 华为Mate10            | 10    |  ✅  |
| HUAWEI     | ANA-AN00                   | 华为P40               | 10    |  ✅  |
| HUAWEI     | ANG-AN00                   | nova 8              | 10    |  ✅  |
| HUAWEI     | BMH-AN10                   | 荣耀30                | 10    |  ✅  |
| HUAWEI     | BRQ-AN00                   | Nova 8 Pro          | 10    |  ✅  |
| HUAWEI     | CDY-AN00                   | 华为nova 7 SE         | 10    |  ✅  |
| HUAWEI     | CDY-AN90                   | 荣耀30s               | 10    |  ✅  |
| HUAWEI     | DVC-AN20                   | 华为畅享20 Pro          | 10    |  ✅  |
| HUAWEI     | EBG-AN00                   | 荣耀30 Pro            | 10    |  ✅  |
| HUAWEI     | EBG-AN10                   | Honor 30 Pro+       | 10    |  ✅  |
| HUAWEI     | EBG-TN00                   | 30 Pro              | 10    |  ✅  |
| HUAWEI     | ELE-AL00                   | 华为 P30              | 10    |  ✅  |
| HUAWEI     | ELS-AN00                   | 华为 P40 Pro 5G       | 10    |  ✅  |
| HUAWEI     | EML-AL00                   | 华为 P20              | 10    |  ✅  |
| HUAWEI     | EVR-AN00                   | HUAWEI Mate 20 X 5G | 10    |  ✅  |
| HUAWEI     | FRL-AN00a                  | 畅享20 Plus           | 10    |  ✅  |
| HUAWEI     | HLK-AL10                   | 荣耀 9X Pro           | 10    |  ✅  |
| HUAWEI     | HMA-AL00                   | 华为 Mate 20          | 10    |  ✅  |
| HUAWEI     | HMA-TL00                   | Mate20              | 10    |  ✅  |
| HUAWEI     | HRY-AL00Ta                 | 荣耀20i               | 10    |  ✅  |
| HUAWEI     | JEF-AN00                   | 华为 nova7 5G         | 10    |  ✅  |
| HUAWEI     | JEF-AN20                   | 华为nova 7            | 10    |  ✅  |
| HUAWEI     | JER-AN10                   | 华为nova 7 Pro        | 10    |  ✅  |
| HUAWEI     | JSC-AN00                   | nova 8 SE           | 10    |  ✅  |
| HUAWEI     | LIO-AN00                   | 华为 Mate 30 Pro      | 10    |  ✅  |
| HUAWEI     | LIO-AN00m                  | Mate 30E Pro 5G     | 10    |  ✅  |
| HUAWEI     | LYA-AL00                   | 华为 Mate 20 Pro      | 10    |  ✅  |
| HUAWEI     | MOA-AL00                   | 荣耀畅玩9A              | 10    |  ✅  |
| HUAWEI     | NEO-AL00                   | 华为Mate RS 保时捷版      | 10    |  ✅  |
| HUAWEI     | NOH-AN00                   | HUAWEI Mate 40 Pro  | 10    |  ✅  |
| HUAWEI     | OCE-AN10                   | Mate 40             | 10    |  ✅  |
| HUAWEI     | OCE-AN50                   | Mate 40E            | 10    |  ✅  |
| HUAWEI     | OXF-AN00                   | 荣耀V30               | 10    |  ✅  |
| HUAWEI     | OXF-AN10                   | 荣耀V30 PRO           | 10    |  ✅  |
| HUAWEI     | OXP-AN00                   | Play4 Pro           | 10    |  ✅  |
| HUAWEI     | PCT-AL10                   | 荣耀V20               | 10    |  ✅  |
| HUAWEI     | SEA-AL10                   | 华为nova 5 Pro        | 10    |  ✅  |
| HUAWEI     | STK-AL00                   | 华为畅享10 Plus         | 10    |  ✅  |
| HUAWEI     | TAS-AL00                   | Mate 30             | 10    |  ✅  |
| HUAWEI     | TAS-AN00                   | 华为 Mate 30 5G       | 10    |  ✅  |
| HUAWEI     | TEL-AN00a                  | 荣耀X10               | 10    |  ✅  |
| HUAWEI     | TNN-AN00                   | 麦芒9                 | 10    |  ✅  |
| HUAWEI     | TNNH-AN00                  | Play4               | 10    |  ✅  |
| HUAWEI     | TNY-AL00                   | 荣耀Magic2            | 10    |  ✅  |
| HUAWEI     | VOG-AL00                   | 华为P30 Pro           | 10    |  ✅  |
| HUAWEI     | WKG-AN00                   | 畅享20 5G             | 10    |  ✅  |
| HUAWEI     | YAL-AL00                   | 荣耀20                | 10    |  ✅  |
| HUAWEI     | YAL-AL50                   | 荣耀20S               | 10    |  ✅  |
| MEIZU      | meizu 17 Pro               | 17 Pro              | 10    |  ✅  |
| ONEPLUS    | IN2010                     | 一加8                 | 10    |  ✅  |
| ONEPLUS    | ONEPLUS A5010              | 一加5T                | 10    |  ✅  |
| OPPO       | PAAM00                     | R15 梦镜版             | 10    |  ✅  |
| OPPO       | PBCM30                     | OPPO K1             | 10    |  ✅  |
| OPPO       | PBEM00                     | OPPO R17            | 10    |  ✅  |
| OPPO       | PCKM00                     | OPPO Reno2          | 10    |  ✅  |
| OPPO       | PCLM50                     | OPPO Reno3元气版       | 10    |  ✅  |
| OPPO       | PCNM00                     | OPPO K5             | 10    |  ✅  |
| OPPO       | PDAM10                     | OPPO A52            | 10    |  ✅  |
| OPPO       | PDEM10                     | OPPO FIND X2        | 10    |  ✅  |
| OPPO       | PDEM30                     | Find X2 Pro         | 10    |  ✅  |
| OPPO       | PDHM00                     | OPPO Ace2           | 10    |  ✅  |
| OPPO       | PDNM00                     | OPPO Reno4 Pro      | 10    |  ✅  |
| OPPO       | PDPM00                     | oppo Reno4 5G       | 10    |  ✅  |
| OPPO       | PERM00                     | K7x                 | 10    |  ✅  |
| OnePlus    | HD1900                     | 一加7T                | 10    |  ✅  |
| REALME     | RMX2201                    | Realme V3 5G        | 10    |  ✅  |
| SAMSUNG    | SM-A9200                   | Galaxy A9s          | 10    |  ✅  |
| SAMSUNG    | SM-F7000                   | Galaxy Z Flip       | 10    |  ✅  |
| SAMSUNG    | SM-G7810                   | Galaxy S20 FE 5G    | 10    |  ✅  |
| SAMSUNG    | SM-G9650                   | 三星 Galaxy S9+       | 10    |  ✅  |
| SAMSUNG    | SM-G9810                   | 三星Galaxy S20 5G     | 10    |  ✅  |
| VIVO       | V1831A                     | VIVO S1             | 10    |  ✅  |
| VIVO       | V1923A                     | NEX 3               | 10    |  ✅  |
| VIVO       | V1950A                     | VIVO NEX 3S         | 10    |  ✅  |
| VIVO       | V2001A                     | VIVO X50            | 10    |  ✅  |
| VIVO       | V2011A                     | X50 Pro+            | 10    |  ✅  |
| VIVO       | V2023A                     | iQOO U1             | 10    |  ✅  |
| XIAOMI     | M2004J7AC                  | Redmi 10X           | 10    |  ✅  |
| XIAOMI     | M2010J19SC                 | Redmi Note 9 4G     | 10    |  ✅  |
| XIAOMI     | MI 8 Explorer Edition      | 8 透明探索版             | 10    |  ✅  |
| Xiaomi     | M2003J15SC                 | Redmi 10X 4G        | 10    |  ✅  |
| Xiaomi     | M2004J19C                  | Redmi 9             | 10    |  ✅  |
| Xiaomi     | M2004J7AC                  | Redmi 10X           | 10    |  ✅  |
| Xiaomi     | M2007J22C                  | Redmi Note 9 5G     | 10    |  ✅  |
| Xiaomi     | M2010J19SC                 | Redmi Note 9 4G     | 10    |  ✅  |
| Xiaomi     | MI 8 UD                    | MI 8 UD             | 10    |  ✅  |
| Xiaomi     | Mi 10                      | 小米10                | 10    |  ✅  |
| Xiaomi     | Redmi K20 Pro              | 红米 K20 Pro          | 10    |  ✅  |
| Xiaomi     | Redmi K30 5G               | Redmi K30 5G        | 10    |  ✅  |
| Xiaomi     | Redmi K30 Pro              | 红米 K30 Pro          | 10    |  ✅  |
| Xiaomi     | Redmi Note 8 Pro           | Redmi Note 8 Pro    | 10    |  ✅  |
| ZTE        | ZTE 8010                   | 中兴Blade V2020 Smart | 10    |  ✅  |
| ZTE        | ZTE A2121                  | Axon 20 5G          | 10    |  ✅  |
| realme     | RMX1931                    | X2 Pro              | 10    |  ✅  |
| realme     | RMX2121                    | realme X7 Pro       | 10    |  ✅  |
| samsung    | SM-A6060                   | Galaxy A60          | 10    |  ✅  |
| samsung    | SM-G9650                   | 三星 Galaxy S9+       | 10    |  ✅  |
| samsung    | SM-G9860                   | 三星Galaxy S20+ 5G    | 10    |  ✅  |
| vivo       | V1821A                     | VIVO NEX 双屏版        | 10    |  ✅  |
| vivo       | V1831A                     | VIVO S1             | 10    |  ✅  |
| vivo       | V1838A                     | VIVO X27            | 10    |  ✅  |
| vivo       | V1923A                     | NEX 3               | 10    |  ✅  |
| vivo       | V1938CT                    | VIVO X30            | 10    |  ✅  |
| vivo       | V1955A                     | VIVO iQOO 3         | 10    |  ✅  |
| vivo       | V1962A                     | VIVO S6             | 10    |  ✅  |
| vivo       | V1965A                     | VIVO Y50            | 10    |  ✅  |
| vivo       | V1981A                     | VIVO iQOO Neo3      | 10    |  ✅  |
| vivo       | V1986A                     | VIVO iQOO Z1        | 10    |  ✅  |
| vivo       | V2001A                     | VIVO X50            | 10    |  ✅  |
| vivo       | V2005A                     | VIVO X50 Pro        | 10    |  ✅  |
| vivo       | V2011A                     | X50 Pro+            | 10    |  ✅  |
| vivo       | V2012A                     | VIVO iQOO Z1x       | 10    |  ✅  |
| vivo       | V2023A                     | iQOO U1             | 10    |  ✅  |
| BLACKSHARK | SKR-A0                     | 黑鲨1代                | 9    |  ✅  |
| GOOGLE     | Pixel 3a                   | Pixel 3A            | 9    |  ✅  |
| HISENSE    | HNR550T                    | Hisense F50         | 9    |  ✅  |
| HUAWEI     | BKL-AL00                   | 荣耀 V10              | 9    |  ✅  |
| HUAWEI     | BKL-AL20                   | 荣耀V10               | 9    |  ✅  |
| HUAWEI     | BLA-AL00                   | Mate 10 Pro         | 9    |  ✅  |
| HUAWEI     | BND-AL10                   | 荣耀畅玩 7X             | 9    |  ✅  |
| HUAWEI     | COL-AL10                   | 荣耀10                | 9    |  ✅  |
| HUAWEI     | COR-AL10                   | 荣耀Play              | 9    |  ✅  |
| HUAWEI     | DUK-TL30                   | V9 移动全网通            | 9    |  ✅  |
| HUAWEI     | EML-AL00                   | 华为 P20              | 9    |  ✅  |
| HUAWEI     | GLK-AL00                   | Nova 5i             | 9    |  ✅  |
| HUAWEI     | HMA-AL00                   | 华为 Mate 20          | 9    |  ✅  |
| HUAWEI     | HRY-AL00Ta                 | 荣耀20i               | 9    |  ✅  |
| HUAWEI     | HRY-AL00a                  | 华为 荣耀10 青春版         | 9    |  ✅  |
| HUAWEI     | INE-AL00                   | 华为 nova3i           | 9    |  ✅  |
| HUAWEI     | JKM-AL00a                  | 为畅享9 Plus           | 9    |  ✅  |
| HUAWEI     | JKM-AL00b                  | 华为畅享9 Plus          | 9    |  ✅  |
| HUAWEI     | JSN-AL00a                  | 荣耀8X                | 9    |  ✅  |
| HUAWEI     | LLD-AL10                   | 荣耀9青春版              | 9    |  ✅  |
| HUAWEI     | LON-AL00                   | 华为 Mate 9 pro       | 9    |  ✅  |
| HUAWEI     | MHA-AL00                   | 华为 Mate 9           | 9    |  ✅  |
| HUAWEI     | PAR-AL00                   | 华为 nova 3           | 9    |  ✅  |
| HUAWEI     | VKY-AL00                   | P10 Plus            | 9    |  ✅  |
| HUAWEI     | VOG-AL00                   | 华为P30 Pro           | 9    |  ✅  |
| HUAWEI     | VTR-AL00                   | P10                 | 9    |  ✅  |
| HUAWEI     | YAL-AL00                   | 荣耀20                | 9    |  ✅  |
| ONEPLUS    | ONEPLUS A6010              | 一加6T                | 9    |  ✅  |
| OPPO       | OPPO R11s                  | OPPO R11s           | 9    |  ✅  |
| OPPO       | OPPO R11s Plus             | OPPO R11s Plus      | 9    |  ✅  |
| OPPO       | PACM00                     | OPPO R15            | 9    |  ✅  |
| OPPO       | PACT00                     | R15                 | 9    |  ✅  |
| OPPO       | PADM00                     | OPPO A3             | 9    |  ✅  |
| OPPO       | PAFM00                     | OPPO Find X         | 9    |  ✅  |
| OPPO       | PBBT00                     | A7x                 | 9    |  ✅  |
| OPPO       | PBCM10                     | OPPO R15x           | 9    |  ✅  |
| OPPO       | PBEM00                     | OPPO R17            | 9    |  ✅  |
| OPPO       | PCAM00                     | OPPO Reno           | 9    |  ✅  |
| OPPO       | PCAM10                     | OPPO A9             | 9    |  ✅  |
| OPPO       | PCGM00                     | OPPO K3             | 9    |  ✅  |
| SAMSUNG    | SM-A705F                   | Galaxy A70          | 9    |  ✅  |
| SAMSUNG    | SM-G9650                   | 三星 Galaxy S9+       | 9    |  ✅  |
| VIVO       | V1923A                     | NEX 3               | 9    |  ✅  |
| VIVO       | vivo NEX A                 | VIVO NEX A          | 9    |  ✅  |
| VIVO       | vivo X21UD A               | VIVO X21 屏幕指纹版      | 9    |  ✅  |
| XIAOMI     | MI 9 Transparent Edition   | 小米9 透明尊享版           | 9    |  ✅  |
| XIAOMI     | MIX 2S                     | 小米 MIX2S            | 9    |  ✅  |
| XIAOMI     | Redmi 7                    | 红米 7                | 9    |  ✅  |
| XIAOMI     | Redmi 8                    | 红米 8                | 9    |  ✅  |
| Xiaomi     | MI 8 SE                    | 小米8 SE              | 9    |  ✅  |
| Xiaomi     | Redmi K20 Pro              | 红米 K20 Pro          | 9    |  ✅  |
| Xiaomi     | Redmi Note 5               | 红米Note 5            | 9    |  ✅  |
| Xiaomi     | Redmi Note 7               | 红米Note 7            | 9    |  ✅  |
| Xiaomi     | Redmi Note 7 Pro           | 红米Note 7 Pro        | 9    |  ✅  |
| vivo       | V1813BT                    | VIVO Z3             | 9    |  ✅  |
| vivo       | V1816A                     | VIVO X23 炫彩版        | 9    |  ✅  |
| vivo       | V1821A                     | VIVO NEX 双屏版        | 9    |  ✅  |
| vivo       | V1831A                     | VIVO S1             | 9    |  ✅  |
| vivo       | V1838A                     | VIVO X27            | 9    |  ✅  |
| vivo       | V1901A                     | VIVO Y3             | 9    |  ✅  |
| vivo       | V1916A                     | VIVO iQOO Pro 5G    | 9    |  ✅  |
| vivo       | V1934A                     | VIVO Y5s            | 9    |  ✅  |
| vivo       | V1945A                     | VIVO Y9s            | 9    |  ✅  |
| vivo       | vivo X21A                  | VIVO X21A           | 9    |  ✅  |
| BLACKSHARK | SKR-A0                     | 黑鲨1代                | 8.1.0    |  ✅  |
| HUAWEI     | BLA-AL00                   | Mate 10 Pro         | 8.1.0    |  ✅  |
| HUAWEI     | CLT-L29                    | P20 Pro             | 8.1.0    |  ✅  |
| HUAWEI     | COL-L29                    | 10 国际版              | 8.1.0    |  ✅  |
| HUAWEI     | DUB-AL00                   | 华为畅享9               | 8.1.0    |  ✅  |
| HUAWEI     | JSN-AL00a                  | 荣耀8X                | 8.1.0    |  ✅  |
| OPPO       | OPPO R11 Plusk             | R11 Plusk           | 8.1.0    |  ✅  |
| OPPO       | OPPO R11 Pluskt            | R11 Plus kt         | 8.1.0    |  ✅  |
| OPPO       | OPPO R11s                  | OPPO R11s           | 8.1.0    |  ✅  |
| OPPO       | OPPO R11s Plus             | OPPO R11s Plus      | 8.1.0    |  ✅  |
| OPPO       | PAAM00                     | R15 梦镜版             | 8.1.0    |  ✅  |
| OPPO       | PACT00                     | R15                 | 8.1.0    |  ✅  |
| OPPO       | PADM00                     | OPPO A3             | 8.1.0    |  ✅  |
| OPPO       | PBAM00                     | OPPO A5             | 8.1.0    |  ✅  |
| OPPO       | PBCM30                     | OPPO K1             | 8.1.0    |  ✅  |
| OnePlus    | ONEPLUS A6000              | 一加手机6               | 8.1.0    |  ✅  |
| VIVO       | V1813A                     | VIVO Y97            | 8.1.0    |  ✅  |
| VIVO       | V1818A                     | VIVO Y93            | 8.1.0    |  ✅  |
| XIAOMI     | MI 8 Explorer Edition      | 8 透明探索版             | 8.1.0    |  ✅  |
| XIAOMI     | Redmi 6                    | Redmi 6             | 8.1.0    |  ✅  |
| Xiaomi     | MI 5X                      | 5X                  | 8.1.0    |  ✅  |
| Xiaomi     | MI 6X                      | 小米6X                | 8.1.0    |  ✅  |
| Xiaomi     | MI 8                       | 小米8                 | 8.1.0    |  ✅  |
| Xiaomi     | MI 8 Lite                  | 小米8 Lite            | 8.1.0    |  ✅  |
| Xiaomi     | MI 8 SE                    | 小米8 SE              | 8.1.0    |  ✅  |
| Xiaomi     | Redmi 5 Plus               | 红米5 Plus            | 8.1.0    |  ✅  |
| vivo       | V1816A                     | VIVO X23 炫彩版        | 8.1.0    |  ✅  |
| vivo       | vivo X20A                  | VIVO X20 A          | 8.1.0    |  ✅  |
| vivo       | vivo X9s L                 | VIVO X9s L          | 8.1.0    |  ✅  |
| HUAWEI     | BAC-AL00                   | nova 2 Plus         | 8.0.0    |  ✅  |
| HUAWEI     | BND-AL00                   | 畅玩7X                | 8.0.0    |  ✅  |
| HUAWEI     | BND-AL10                   | 荣耀畅玩 7X             | 8.0.0    |  ✅  |
| HUAWEI     | EVA-AL10                   | 华为P9                | 8.0.0    |  ✅  |
| HUAWEI     | FRD-AL10                   | 荣耀8 高配版             | 8.0.0    |  ✅  |
| HUAWEI     | HUAWEI NXT-AL10            | 华为 Mate 8           | 8.0.0    |  ✅  |
| HUAWEI     | HWI-AL00                   | 华为 nova 2s          | 8.0.0    |  ✅  |
| HUAWEI     | LLD-AL20                   | 荣耀9i                | 8.0.0    |  ✅  |
| HUAWEI     | PRA-AL00                   | 荣耀8青春版              | 8.0.0    |  ✅  |
| SAMSUNG    | SM-G8850                   | 三星GalaxyA9          | 8.0.0    |  ✅  |
| XIAOMI     | MI 5                       | 小米5                 | 8.0.0    |  ✅  |
| XIAOMI     | Mi Note 2                  | Note 2              | 8.0.0    |  ✅  |
| Xiaomi     | MI 5s Plus                 | 小米5s Plus           | 8.0.0    |  ✅  |
| Xiaomi     | MI 6                       | 小米6                 | 8.0.0    |  ✅  |
| Xiaomi     | MIX 2S                     | 小米 MIX2S            | 8.0.0    |  ✅  |
| blackshark | SKR-A0                     | 黑鲨1代                | 8.0.0    |  ✅  |
| MEIZU      | M6 Note                    | M6 Note             | 7.1.2    |  ✅  |
| XIAOMI     | Redmi 5A                   | 红米5A                | 7.1.2    |  ✅  |
| XIAOMI     | Redmi Note 5A              | 红米Note 5A           | 7.1.2    |  ✅  |
| Xiaomi     | MI 5X                      | 5X                  | 7.1.2    |  ✅  |
| Xiaomi     | Redmi 5 Plus               | 红米5 Plus            | 7.1.2    |  ✅  |
| vivo       | vivo X9                    | VIVO X9             | 7.1.2    |  ✅  |
| vivo       | vivo X9L                   | VIVO X9L            | 7.1.2    |  ✅  |
| vivo       | vivo X9Plus                | VIVO X9Plus         | 7.1.2    |  ✅  |
| Meizu      | 15                         | 15                  | 7.1.1  |  ✅  |
| OPPO       | OPPO A73                   | OPPO A73            | 7.1.1  |  ✅  |
| OPPO       | OPPO A77                   | A77                 | 7.1.1  |  ✅  |
| OPPO       | OPPO A83                   | OPPO A83            | 7.1.1  |  ✅  |
| OPPO       | OPPO A83t                  | A83T                | 7.1.1  |  ✅  |
| SAMSUNG    | SM-N9508                   | Galaxy Note8        | 7.1.1  |  ✅  |
| SMARTISAN  | OS105                      | 锤子科技坚果Pro 2         | 7.1.1  |  ✅  |
| VIVO       | vivo Xplay6                | VIVO Xplay 6        | 7.1.1  |  ✅  |
| XIAOMI     | MIX 2                      | MIX 2               | 7.1.1  |  ✅  |
| Xiaomi     | MI 6                       | 小米6                 | 7.1.1  |  ✅  |
| Xiaomi     | MI MAX 2                   | Max2                | 7.1.1  |  ✅  |
| Xiaomi     | Mi Note 3                  | 小米Note 3            | 7.1.1  |  ✅  |
| HUAWEI     | BLN-AL10                   | 畅玩6X                | 7     |  ✅  |
| HUAWEI     | BLN-AL30                   | 畅玩6X                | 7     |  ✅  |
| HUAWEI     | BLN-AL40                   | 荣耀畅玩6x              | 7     |  ✅  |
| HUAWEI     | FRD-AL00                   | 荣耀8                 | 7     |  ✅  |
| HUAWEI     | FRD-AL10                   | 荣耀8 高配版             | 7     |  ✅  |
| HUAWEI     | HUAWEI CAZ-AL10            | nova 高配版            | 7     |  ✅  |
| HUAWEI     | JMM-AL10                   | V9 play             | 7     |  ✅  |
| HUAWEI     | PRA-AL00                   | 荣耀8青春版              | 7     |  ✅  |
| HUAWEI     | SLA-AL00                   | 畅享7                 | 7     |  ✅  |
| HUAWEI     | STF-AL10                   | 荣耀9 尊享版             | 7     |  ✅  |
| HUAWEI     | TRT-AL00A                  | 畅享7 Plus            | 7     |  ✅  |
| SAMSUNG    | SM-G9280                   | 三星GALAXY S6 Edge+   | 7     |  ✅  |
| XIAOMI     | MI 5                       | 小米5                 | 7     |  ✅  |
| Xiaomi     | MI 5s                      | 5s                  | 7     |  ✅  |
| samsung    | SM-G9350                   | Galaxy S7 edge      | 7     |  ✅  |
| samsung    | SM-G9550                   | Galaxy S8+          | 7     |  ✅  |
| MEIZU      | M2 E                       | 魅族魅蓝E2              | 6.0.1  |  ✅  |
| OPPO       | OPPO R9s Plus              | OPPO R9s Plus       | 6.0.1  |  ✅  |
| OPPO       | OPPO R9sk                  | OPPO R9sk           | 6.0.1  |  ✅  |
| SAMSUNG    | SM-G9350                   | Galaxy S7 edge      | 6.0.1  |  ✅  |
| XIAOMI     | Redmi 4X                   | 红米Note 4X           | 6.0.1  |  ✅  |
| Xiaomi     | Redmi Note 4X              | 红米 Note 4X          | 6.0.1  |  ✅  |
| vivo       | vivo Y66                   | VIVO Y66            | 6.0.1  |  ✅  |
| HUAWEI     | HUAWEI MLA-AL10            | 麦芒5 高配版             | 6     |  ✅  |
| XIAOMI     | Redmi Note 4X              | 红米 Note 4X          | 6     |  ✅  |
| HUAWEI     | BLN-AL10                   | 畅玩6X                | 6     |  ✅  |
| HUAWEI     | HUAWEI CAZ-AL10            | nova 高配版            | 6     |  ✅  |
| MEIZU      | M5 Note                    | 魅族M5 Note           | 6     |  ✅  |
| HUAWEI     | NTS-AL00                   | Magic               | 6     |  ✅  |
| Meitu      | MP1602                     | T8                  | 6     |  ✅  |
| MEIZU      | PRO 6s                     | Pro 6s              | 6     |  ✅  |
| VIVO       | vivo Xplay5A               | VIVO Xplay 5        | 5.1.1 |  ✅  |
| vivo       | vivo X7                    | VIVO X7             | 5.1.1 |  ✅  |
| OPPO       | OPPO R9 Plustm A           | R9 Plustm A         | 5.1.1 |  ❌  |
| OPPO       | A37f                       | A37f                | 5.1.1 |  ❌  |
| OPPO       | OPPO A59m                  | OPPO A59m           | 5.1   |  ❌  |
| OPPO       | OPPO A59s                  | OPPO A59s           | 5.1   |  ❌  |