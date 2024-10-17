# 프로세스

1. 사용자 입력 받기
2. 입력값 파싱
    1. 커스텀 구분자 처리
    2. 토큰화
    3. 검증 및 예외 처리
    4. 숫자 추출
    5. 결과 반환
3. 계산
    1. 총합 계산
    2. 예외 처리
    3. 결과 반환
4. 결과 출력

---

# 기능 요구사항

1. 사용자가 입력한 문자열을 구분자를 기준으로 분리한다.
    1. 기본 구분자는 `','`, `':'`이다.
    2. 커스텀 구분자를 사용할 수 있다.
        1. 커스텀 구분자는 `//`와 `\n` 사이에 위치한다.
        2. 커스텀 구분자는 `'문자'`이다.
        3. 커스텀 구분자는 숫자가 될 수 없다.
    3. 입력받은 숫자는 양수이다. (0은 포함하지 않고, 소수점이 나올 수 있다.)
    4. 입력받은 값이 숫자 표현 범위를 초과할 경우, 에러를 발생시킨다.
2. 총합을 계산한다.
    1. 숫자들의 합이 표현할 수 있는 최대값을 초과할 경우, 에러를 발생시킨다.
    2. 더한 총합 값을 반환한다.
3. 결과를 출력한다.

---

# 기능 목록

## 1. Parser

문자열(사용자 입력)을 파싱 상위 클래스

#### CustomSepParser

커스텀 구분자 처리 클래스

#### Validator

토큰 검증 클래스

#### Tokenizer

문자열을 토큰화하 하여 숫자를 추출 클래스

## 2. Calculator

파싱된 숫자들의 총합을 계산 클래스

## 3. ArgumentException

예외 사항 정의 및 처리 클래스

---

# 예외 사항 정리

#### General

- 입력값이 없을 경우, 에러를 발생시킨다.

#### Custom Separator

- 커스텀 구분자가 숫자일 경우, 에러를 발생시킨다.
- 커스텀 구분자가 기본 구분자와 중복되는 경우, 에러를 발생시킨다.
- 커스텀 구분자 입력을 하였으나 커스텀 구분자가 없을 경우, 에러를 발생시킨다.
- 커스텀 구분자가 문자열일 경우, 에러를 발생시킨다.
- 커스텀 구분자가 숫자일 경우, 에러를 발생시킨다.
- 커스텀 구분자가 여러 개일 경우, 에러를 발생시킨다.

#### Operand

- 피연산자의 숫자가 표현 범위를 초과할 경우, 에러를 발생시킨다.
- 피연산자에 문자가 포함되어 있을 경우, 에러를 발생시킨다.
    - 소수점을 표현하기 위한 '.'은 제외한다.
- 소수점 표현 범위를 초과할 경우, 에러를 발생시킨다.

#### Calculation

- 계산 결과가 표현 범위를 초과할 경우, 에러를 발생시킨다.

---
