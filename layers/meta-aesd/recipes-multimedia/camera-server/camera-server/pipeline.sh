#!/usr/bin/env bash

gst-launch-1.0 \
    v4l2src \
    ! 'video/x-raw,width=640,height=480' \
    ! nvvidconv \
    ! nvv4l2h264enc \
    ! queue \
    ! rtspclientsink location=rtsp://localhost:8554/mystream latency=0
