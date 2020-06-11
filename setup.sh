#!/bin/bash
echo "Building..."
mvn clean compile assembly:single
echo "Done!"