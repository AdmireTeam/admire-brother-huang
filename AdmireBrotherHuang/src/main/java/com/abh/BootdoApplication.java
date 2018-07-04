package com.abh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class BootdoApplication {
	public static void main(String[] args) {
		SpringApplication.run(BootdoApplication.class, args);
		System.out.println("\n" +
				"     _       _           _          ____            _   _               _   _                         \n" +
				"    / \\   __| |_ __ ___ (_)_ __ ___| __ ) _ __ ___ | |_| |__   ___ _ __| | | |_   _  __ _ _ __   __ _ \n" +
				"   / _ \\ / _` | '_ ` _ \\| | '__/ _ \\  _ \\| '__/ _ \\| __| '_ \\ / _ \\ '__| |_| | | | |/ _` | '_ \\ / _` |\n" +
				"  / ___ \\ (_| | | | | | | | | |  __/ |_) | | | (_) | |_| | | |  __/ |  |  _  | |_| | (_| | | | | (_| |\n" +
				" /_/   \\_\\__,_|_| |_| |_|_|_|  \\___|____/|_|  \\___/ \\__|_| |_|\\___|_|  |_| |_|\\__,_|\\__,_|_| |_|\\__, |\n" +
				"                                                                                                |___/ ");


	}



}
