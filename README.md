<h1 align="center">Welcome to Which toilet project refactoring server π</h1>

κ³΅κ³΅ νμ₯μ€μ λν λ¦¬λ·°μ μ²­κ²°λλ₯Ό λ¨κΈ°κ³  μμΉ, νμ₯μ§ μ λ¬΄, μ₯μ μΈ νμ₯μ€, λ³κΈ° μ’λ₯ λ±μ μ΅μ μ λ³΄λ₯Ό μ κ³΅νκ³  νμ₯μ€μ λν μ¬μ§κ³Ό μ¬μ©μ νλ‘ν μ¬μ§μ μλ‘λ ν  μ μλ CRUD μ΄νλ¦¬μΌμ΄μ μλλ€.

## κΈ°μ μ€ν

<p>
  <img src="https://img.shields.io/badge/-SpringBoot-brightgreen"/>&nbsp
  <img src="https://img.shields.io/badge/-SpringSecurity-lightgrey"/>
  <img src="https://img.shields.io/badge/-JPA-blue"/>&nbsp
  <img src="https://img.shields.io/badge/-AWS-orange"/>&nbsp
  <img src="https://img.shields.io/badge/-MySQL-yellow"/>&nbsp
  <img src="https://img.shields.io/badge/-Docker-blue"/>&nbsp
  <img src="https://img.shields.io/badge/-Jenkins-black"/>&nbsp
  <img src="https://img.shields.io/badge/-JWT-yellowgreen"/>&nbsp
  <img src="https://img.shields.io/badge/-Nginx-violet"/>&nbsp
</p>

## κ°λ°νκ²½
- java11
- gradle
- spring-boot 2.7.3

## μμ€ν κ΅¬μ±λ
![αα©αα³αα©α―αα΅αα©](https://user-images.githubusercontent.com/59994664/195478735-ecdd02d5-028a-44e1-9b8f-6874ec6eae57.png)


## ERD

<img width="790" alt="image" src="https://user-images.githubusercontent.com/59994664/195479501-42be20b1-1ffd-4eb7-b154-d966cf35088a.png">

## κ°λ° μΌμ§
- JWT ν ν° μΈμ¦ κ°λ°(22/09/21) - `commit` : [06f27](https://github.com/Stark-Industries0417/toilet_refactoring/commit/06f27a4d988bb64c351cf9f3a2a5d85c3883f4cd)
- νμκ°μ API κ°λ°(22/09/23) - `commit` : [e813e](https://github.com/Stark-Industries0417/toilet_refactoring/commit/e813e87213f8a104d9a8415c116deca37a6591e3)
- λ‘κ·ΈμΈ API κ°λ°(22/09/23) - `commit` : [86253](https://github.com/Stark-Industries0417/toilet_refactoring/commit/862536c5e11a23ecf4e8f08ad3d88454f4581386)
- JWT ν ν° μλ¬ handler(22/10/04) - `commit`: [95272](https://github.com/Stark-Industries0417/toilet_refactoring/commit/95272869ca5d0e30707651fb2bd734f804c6614d)
- JWT νν° μ μ©(22/10/04) - `commit` : [b4deb7](https://github.com/Stark-Industries0417/toilet_refactoring/commit/b4deb7956cf4584895087ec2c7b00566e6b91f7d)
- AWS S3 μ΄λ―Έμ§ upload κΈ°λ₯ κ°λ°(22/10/05) - `commit` : [4e98e](https://github.com/Stark-Industries0417/toilet_refactoring/commit/4e98eeca71c9522735b357c0e8fa15acdbdcb4dc)
- μ¬μ©μ νλ‘ν μ΄λ―Έμ§ upload κ°λ°(22/10/05) - `commit` : [a52c9](https://github.com/Stark-Industries0417/toilet_refactoring/commit/a52c9e32ac082f9187c72c822a6cd459f82d3e69)
- Mysql replication μ μ©νμ¬ datasource λΆκΈ° μ€μ (22/10/09) - `commit` : [7bf4ed](https://github.com/Stark-Industries0417/toilet_refactoring/commit/7bf4ed91ab9ac6502c20f2b82eb5a2067c51f126)
- νμ₯μ€ μΆκ°, μ£Όμ μ λ³΄λ‘ νμ₯μ€ λ°ν API κ°λ°(22/10/11) - `commit` : [ba000](https://github.com/Stark-Industries0417/toilet_refactoring/commit/ba000e347a115f76ec41e884bb879754cb1d8fe5)
- λ΄ μ£Όλ³ νμ₯μ€ λ°ν API κ°λ°(22/10/11) - `commit` : [c6503b](https://github.com/Stark-Industries0417/toilet_refactoring/commit/c6503b5f6d48f1e1a487e3117bf2c998bd516d26)
- λ¦¬λ·° μΆκ° API κ°λ°(220/10/12) - `commit` : [69c66](https://github.com/Stark-Industries0417/toilet_refactoring/commit/69c66f5d9ea526bf6fff5a988ed1962c6e9143be), 
[aa4fe](https://github.com/Stark-Industries0417/toilet_refactoring/commit/aa4fe0fdfc0c2781dd377bf0047de466db8024fa)
- νμ₯μ€ μ¬μ§ μΆκ° API κ°λ°(22/10/12) - `commit` : [f259d](https://github.com/Stark-Industries0417/toilet_refactoring/commit/f259d60837eade4637dcb0277d3f743507236aa5)
- νμ₯μ€ μ΅μ κΈ°λ₯ κ°λ°(22/10/12) - `commit1` : [54179](https://github.com/Stark-Industries0417/toilet_refactoring/commit/54179103b76213bb7695dcfe236952aa1c560262)
- λ΄ μ£Όλ³ νμ₯μ€ μ λ³΄ redis μΊμ μλ² μ¬μ©(22/10/14) - `commit` : [4d3bdd](https://github.com/Stark-Industries0417/toilet_refactoring/commit/4d3bddc5c3b3a2812c65f7b444257030b44a061d)
- λͺ¨λ  μ¬μ©μ λ³ λ¦¬λ·°μ νμ₯μ€ μ΅μ μ λ³΄ λ°ν API κ°λ°(22/10/19) - `commit` : [9778d3](https://github.com/Stark-Industries0417/toilet_refactoring/commit/9778d359d0400321b8b9851fa7d08593a6a430d8)
- Redis lettuce λΆμ° λ½μΌλ‘ λ¦¬λ·° μ κ³  νμ λ°μ΄ν° μ ν©μ± κ΅¬ν(22/10/20) - `commit` : [427aa](https://github.com/Stark-Industries0417/toilet_refactoring/commit/427aaca41cd1627908bbf60809ca296e9c758e69), [9bf94](https://github.com/Stark-Industries0417/toilet_refactoring/commit/9bf94d937ab32c83796bc9ee8cc533b4b1030e76)
