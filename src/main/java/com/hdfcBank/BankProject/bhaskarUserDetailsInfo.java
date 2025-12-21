package com.hdfcBank.BankProject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "accounts")
//
//@AllArgsConstructor
//@NoArgsConstructor
public record bhaskarUserDetailsInfo (String message, Map<String, String> contactDetails, List<String> onCallSupport){

}
