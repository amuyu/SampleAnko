# SampleAnko
anko를 사용해서 간단하게 toast, alert dialog 등을 호출하는 샘플앱입니다

## Toast
Toast 메시지 호출
```kotlin
toast("Toast message!!!")
```

## Dialogs
Alert Dialog 를 생성합니다
```kotlin
alert("Hi,","title") {
    yesButton { toast("확인") }
    noButton  { toast("취소") }
}.show()
```

## Selectors
리스트를 갖고 있는 Alert Dialog를 생성합니다
```kotlin
val countries = listOf("Russia", "USA", "Japan", "Australia")
        selector("Where are you from?", countries, { dialogInterface, i ->
            toast("So you're living in ${countries[i]}, right?")
        })
```

## Progress dialogs
progress dialog 를 생성합니다
```kotlin
progressDialog(message = "Please wait a bit…", title = "Fetching data").show()
```