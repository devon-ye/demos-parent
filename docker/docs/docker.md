# docker


## DockerFile
 * 指令形式 INSTRUCTION arguments
 * 执行顺序按在dockerfile中出现的顺序
 * 错误的指令会被忽略，且第一条指令必须是FROM指定基础镜像
 * 常见指令
      
             
           FROM  <image> 或<image>:<tag>
           RNER
           RUN  <commond>  shell 或 ["executable","param1","param2"]
           CMD
           EXPOSE
           ENV   <key> <value>   <key>=<value>
           ADD    <src>  <dest>  文件复制  包括 url来源
           COPY   <src>  <dest>   文件复制
           ENTRYPOINT
           VOLUME
           USER
           WORKDIR
           ONBUILD
           
           
             
