package com.teamcoffee.cafe.vo;

//체인점 리스트 
public class CafeChainVO {

 // 체인점코드 
 private String chainCode;

 // 체인점 명 
 private String chainName;

 // 체인점로고 
 private String chainLogo;

 public String getChainCode() {
     return chainCode;
 }

 public void setChainCode(String chainCode) {
     this.chainCode = chainCode;
 }

 public String getChainName() {
     return chainName;
 }

 public void setChainName(String chainName) {
     this.chainName = chainName;
 }

 public String getChainLogo() {
     return chainLogo;
 }

 public void setChainLogo(String chainLogo) {
     this.chainLogo = chainLogo;
 }

 // DjvCafeChain 모델 복사
 public void CopyData(CafeChainVO param)
 {
     this.chainCode = param.getChainCode();
     this.chainName = param.getChainName();
     this.chainLogo = param.getChainLogo();
 }
}
