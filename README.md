# README
# Musinsa Product Management System

## 프로젝트 설명

Musinsa Management System은 상품, 브랜드, 카테고리를 관리하고 조회할 수 있는 시스템입니다. 이 시스템은 다양한 API를 통해 상품 정보를 조회하고 필터링할 수 있는 기능을 제공합니다.

## 구현 범위

- **ProductController**: 상품 관련 요청을 처리하는 컨트롤러 클래스.
- **ProductService**: 상품 비즈니스 로직을 처리하는 서비스 클래스.
- **ProductFacade**: 복잡한 비즈니스 로직을 조율하는 파사드 클래스.
- **Repository**: 상품, 브랜드, 카테고리 정보를 저장하고 조회하는 리포지토리 인터페이스 및 구현체.
- **Entity**: 상품, 브랜드, 카테고리를 나타내는 엔티티 클래스.
- **Config**: Swagger 설정 및 예외 처리를 위한 설정 클래스.
- **Utils**: 가격 포맷팅 등 유틸리티 클래스.

## 코드 빌드, 테스트, 실행 방법

### 빌드 방법

```bash
./gradlew build
```

### 테스트 방법

```bash
./gradlew test
```
### 실행 방법

```bash
./gradlew bootRun
```

## 주요 API

- **카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API**
- **단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을
  조회하는 API**
- **카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API**
- **브랜드 및 상품을 추가 / 업데이트 / 삭제하는 API**

## 추가 정보
- SwaggerAPI 문서는 Swagger를 통해 제공됩니다. **/swagger-ui.html에서 확인할 수 있습니다.**
- 예외 처리: 공통 예외 처리 로직을 포함하고 있으며, 각종 예외 상황에 대한 적절한 응답을 제공합니다.

## 파일 구조
```bash
src/main/kotlin/com/example/demo
├── config
│   ├── exception
│   └── swagger
├── controller
│   └── ProductController.kt
├── entity
│   ├── Brand.kt
│   ├── Category.kt
│   └── Product.kt
├── facade
│   └── ProductFacade.kt
├── repository
│   ├── Product
│   └── brand
├── service
│   ├── CategoryDataService.kt
│   ├── DataService.kt
│   └── ProductService.kt
└── utill
└── FormatPriceWithDecimalFormat.kt
```
