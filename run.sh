#!/bin/bash

# FILE="./src/mainacv01.class"

if [ ! -f "./src/mainacv01.class" ]; then
	echo "Main class doesn't exist, compiling..."
	gmake -C src
fi

java src.mainacv01 $@
