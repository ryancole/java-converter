#!/bin/bash

echo "Building ..."

cd src
javac Converter.java -d ../bin -cp '.:/usr/local/litigance/converter/lib/*:'

echo "Creating JAR file ..."

cd ../bin
jar cf /usr/local/litigance/converter/bin/Converter.jar Converter.class managers/*

cd ..
exit