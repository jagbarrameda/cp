cmake_minimum_required(VERSION 3.5)
project(spoj)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES m9-direct-visibility.cpp)
#set(SOURCE_FILES main.cpp)
add_executable(spoj ${SOURCE_FILES})