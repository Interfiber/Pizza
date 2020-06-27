#!/bin/sh
VERSION=0.3
DOWNLOAD_URl=https://github.com/Interfiber/Pizza/releases/download/v${VERSION}/pizza-dist.tar.gz
function download() {
    echo "Downloading Pizza ${VERSION}..."
    mkdir .pizza
    curl -L $DOWNLOAD_URl -o ./.pizza/pizza.tar.gz
}
download
if [[ $1 == "run" ]]; then
    echo "Running Project..."
    
fi

