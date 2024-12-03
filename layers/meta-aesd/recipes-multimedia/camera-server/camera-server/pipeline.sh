#!/usr/bin/env bash

gst-launch-1.0 \
    v4l2src \
    ! video/x-raw,width=640,height=480 \
    ! videoconvert \
    ! x264enc tune=zerolatency \
    ! rtspclientsink location=rtsp://localhost:8554/mystream latency=0
