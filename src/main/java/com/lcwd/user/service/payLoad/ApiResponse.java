package com.lcwd.user.service.payLoad;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ApiResponse {
	private String message;
	private boolean success;
	private HttpStatus status;
//	public static void builder() {
//		
//	}
//	public ApiResponse(String message, boolean success, HttpStatus status) {
//		super();
//		this.message = message;
//		this.success = success;
//		this.status = status;
//	}
}
