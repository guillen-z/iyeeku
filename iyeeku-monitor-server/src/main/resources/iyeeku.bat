@echo off

set RUN_CLASS="com.iyeeku.watch.main.Main"

set JAVA_OPTION=-Dkey=597E4335A9FE657664A294A6B7D332E6
set JAVA_OPTION=%JAVA_OPTION% -Dukey=11337612A9FE65763B22CDD09441FA04
set JAVA_OPTION=%JAVA_OPTION% -Dikey=14F60F42A9FE65763B22CDD0D6B2D60E
set JAVA_OPTION=%JAVA_OPTION% -Djava.encoding=UTF-8 -Xms100M -Xmx100M

set CLASSPATH=.

setlocal enabledelayedexpansion

for /f %%i in (jar.config) do (
	set CLASSPATH=!CLASSPATH!;./lib/%%i
)

echo %CLASSPATH%

echo Begin Start Iyeeku-Monitor-Server

java -cp %CLASSPATH% %JAVA_OPTION% %RUN_CLASS%

pause