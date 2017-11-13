#!/usr/bin/env bash

#below command will ask for password
ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"

brew install python
brew install npm
npm install -g appium
brew install carthage

# Install XCode from the App Store.
#sudo xcode-select --switch /Applications/Xcode.app