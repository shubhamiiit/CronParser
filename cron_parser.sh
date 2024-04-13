#!/bin/bash

# Set directory paths
SRC_DIR=src
BUILD_DIR=build
MAIN_CLASS=assignment.CronParser

# Create build directory if it doesn't exist
mkdir -p "$BUILD_DIR"

# Compile Java files
javac -d "$BUILD_DIR" "$SRC_DIR/assignment/"*.java "$SRC_DIR/assignment/CronFieldParser/"*.java

# Check for compilation errors
if [ $? -ne 0 ]; then
    echo "Compilation failed."
    exit 1
fi

# Run the main class
java -cp "$BUILD_DIR" "$MAIN_CLASS" "$@"
