#!/usr/bin/env bash

function testForGradle() {
  # Test if user has gradle installed
  echo "[INFO]: Checking for Gradle Install..."
  GRADLE=$(which gradle)
  if [ -f $GRADLE ]; then
    echo "[INFO]: Gradle Install Found!"
    echo "[INFO]: Building Pizza with gradle..."
    echo "[BUILD]: Running 'gradle clean' to clean gradle install..."
    time gradle clean
    echo "[BUILD]: Finished gradle clean"
    echo "[BUILD]: Running 'gradle build' to start build process..."
    time gradle build
    echo "[BUILD]: Finished gradle build"
    echo "[BUILD]: Testing Compiled Jar..."
    OUTPUT=$(java -jar build/libs/Pizza-0.2\ Beta.jar --version)
    if [[ $? != 0 ]]; then
      echo "[BUILD]: Pizza Test Failed!"
      echo "[INFO]: Aborting!"
      exit 1
    fi
    if [[ $? == 0 ]]; then
      echo "[BUILD]: Test Successful!"
      echo "[TEST]: Pizza returned: "
      echo $OUTPUT
      echo "[BUILD]: Ending Build and Testing"
      echo "[INFO]: Pizza is ready for use!"
      echo "[INFO]: Exiting!"
      echo "Goodbye"
      exit 0
  fi
fi
if [ ! -f $GRADLE ]; then
  echo "[INFO]: Gradle Not Found!"
  echo "[INFO]: Using Gradle Wrapper for System..."
  echo "[WRAPPER]: Running gradle wrapper..."
  echo "[BUILD]: Running './gradlew clean'..."
  ./gradlew clean
  echo "[BUILD]: Running ./gradlew build"
  ./gradlew build
  echo "[BUILD]: Done!"
  exit 0
fi
}
testForGradle