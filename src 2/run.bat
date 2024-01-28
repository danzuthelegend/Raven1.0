@echo off
setlocal enabledelayedexpansion

if exist "release" (
    rmdir /s /q "release"
)


echo compiling
javac --module-path lib/javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.graphics -cp .;lib/javacv-platform-1.5.9-bin/*;resources/img;resources/img;resources/xml;resources/models -d release src/main/java/org/raven/controller/GlobalMessageHandler.java

javac --module-path lib/javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.graphics -cp .;release/;lib/javacv-platform-1.5.9-bin/*;resources/img;resources/img;resources/xml;resources/models; -d release src/main/java/org/raven/view/*.java
javac --module-path lib/javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.graphics -cp .;release/;lib/javacv-platform-1.5.9-bin/*;resources/img;resources/img;resources/xml;resources/models; -d release src/main/java/org/raven/models/*.java

javac --module-path lib/javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.graphics -cp .;release/;lib/javacv-platform-1.5.9-bin/*;resources/img;resources/img;resources/xml;resources/models -d release src/main/java/org/raven/controller/ApplicationController.java

javac --module-path lib/javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.graphics -cp .;release/;lib/javacv-platform-1.5.9-bin/*;resources/img;resources/img;resources/xml;resources/models -d release src/main/java/org/raven/*.java







set sourceDirectory=lib
set destinationDirectory=release/lib

xcopy "%sourceDirectory%" "%destinationDirectory%" /E /I /H /Y

set si=resources
set dsti=release/resources

xcopy "%si%" "%dsti%" /E /I /H /Y

echo executing

cd release
mkdir out
java  -cp .;lib/javacv-platform-1.5.9-bin/*;resources/img;resources/xml;resources/models  --module-path lib/javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.graphics  org.raven.main














::Djava.library.path=lib\javacpp-platform-1.5.9-bin\x64


:: javac -cp .;lib\opencv-490\opencv-490.jar hello.java
:: java  --module-path lib/javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.fxml -cp lib\opencv-490\opencv-490.jar -Djava.library.path=lib\opencv-490\x64 hello

:: javac --module-path lib/javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.graphics -d target/src/main/java src/main/java/ui/components/*.java

::java --module-path lib/javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.fxml -cp bin com.yourpackage.YourMainClass

pause