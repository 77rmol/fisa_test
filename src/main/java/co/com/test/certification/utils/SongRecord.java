package co.com.test.certification.utils;


import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.bytedeco.opencv.opencv_core.IplImage;

import java.io.IOException;

public class SongRecord {

    public static void main(String[] args) throws FrameGrabber.Exception, IOException {
        int frameRate = 30;
        int width = 1920;
        int height = 1080;
        String outputFile = "output.mp4";

        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(outputFile, width, height);
        recorder.setFrameRate(frameRate);
        recorder.setVideoCodec(org.bytedeco.ffmpeg.global.avcodec.AV_CODEC_ID_H264);
        recorder.start();

        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0); // 0 para la pantalla principal
        grabber.start();

        long startTime = System.currentTimeMillis();
        long frameNumber = 0;

        while (true) {
            Frame frame = grabber.grab();
            if (frame == null) break;

            recorder.record(frame);
            frameNumber++;

            long elapsedTime = System.currentTimeMillis() - startTime;
            if (elapsedTime > 10000) {
                break;
            }
        }

        grabber.stop();
        recorder.stop();
    }

}
