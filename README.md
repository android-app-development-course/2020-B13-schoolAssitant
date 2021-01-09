# 2020-B13-schoolAssitant
# 校园小助手
本项目APP名称：街舞潮流文化社区

源代码已上传
服务器源代码文件路径：MyDanceFileWeb-add-gb2312

第一阶段任务
（1）选择移动应用开发的主题和内容。

（2）编写《产品方案设计》，包括以下内容:

项目实施可行性报告（行业市场分析、竞争对手或同类产品分析、自身条件分析）
产品定位及目标（用户群分析等）
产品内容总策划（应用流程规划，设计与测试规范，开发日程表）
技术解决方案
推广方案
运营规划书
完成展示链接：
方案设计超链接：街舞潮流文化社区APP产品方案设计.docx

第二阶段任务
APP的UI设计:

1.设计用户流程及其中的关键步骤，每一步骤都是一个主要界面。

2.确定关键界面里的UI元素和布局，以及全局的布局排版风格。

3.确定产品界面的视觉设计风格，包括构图、配色、字体、动效等。

4.交互流程设计，完成全部界面的线框图（如下）设计。

完成展示链接：
UI设计界面展示PPT超链接：项目汇报第二阶段-UI设计报告.pptx

UI设计PPT介绍视频：UI设计PPT介绍视频.mp4

UI实机演示视频：UI实机演示视频.mp4

小组项目第三阶段任务
1、完成app的主要功能。

2、设计测试用例，进行app测试。

3、找10个以上的同学使用app，记录用户体验后的意见和建议。

4、根据用户的意见，改进app。

5、整理材料，准备结题汇报。

完成展示链接：
系统开发说明文件docx文档: 街舞潮流文化社区APP系统开发说明文件.docx

最终产品汇报pptx文档：项目汇报第三阶段.pptx

最终产品演示视频mp4：最终产品演示视频.mp4

apk文件：app-release.apk

源代码食用方法
因为图片和视频采用的是本地服务器，所以需要修改本地服务器的配置文件，

配置文件在app\src\main\java\com\example\dacnce\NetworkUtils.kt文件

修改主机地址和web目录(根据服务器配置内容进行修改-->SEVER_IP, SERVLET_PRE_PATH)

const val APP_ID = "ca1186997e987d6205110e4c23547afb"
private const val PROTOCOL = "http://"
private const val SEVER_IP = "127.0.0.1"
private const val PORT = "8080"
private const val COM = "$PROTOCOL$SEVER_IP:$PORT"

//文件保存路径
const val PIC_PRE_PATH = "$COM/DanceFile"

//web前缀目录
const val SERVLET_PRE_PATH = "$COM/MyDanceFileWeb"

//单个文件servlet
const val POST_PIC_PATH_SERVLET = "$SERVLET_PRE_PATH/FileServlet"

//多个文件servlet
const val PIC_ARRAY_SERVLET = "$SERVLET_PRE_PATH/PicArrayServlet"

//mp4 文件servlet
const val MP4_SERVLET = "$SERVLET_PRE_PATH/Mp4Servlet"
