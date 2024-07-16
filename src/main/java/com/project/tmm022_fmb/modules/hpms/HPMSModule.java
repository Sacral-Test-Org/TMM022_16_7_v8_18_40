package com.project.tmm022_fmb.modules.hpms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HPMSModule {

    @Bean
    public String hpmsModuleBean() {
        return "HPMS Module Bean";
    }

    @Bean
    public PartMasterWindow partMasterWindow() {
        return new PartMasterWindow(609, 300);
    }

    public static class PartMasterWindow {
        private final int width;
        private final int height;

        public PartMasterWindow(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        @Override
        public String toString() {
            return "PartMasterWindow{" +
                    "width=" + width +
                    ", height=" + height +
                    '}';
        }
    }
}