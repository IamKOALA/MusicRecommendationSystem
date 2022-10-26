# Запуск

1. Запустить SpringBootApplication

# Концепция
С помощью ShazamAPI подбирается список песен по заданной

Для добавления пользователя требуется отправлять POST запрос на адрес `http://localhost:8080/music/get-recommended` с JSON в следующем формате:

```json
{
  "songName": "Hand Of Blood",
  "author": "Bullet"
}
``` 

В качестве ответа вернется список подобранных песен, с автором, названием и ссылкой на appleMusic для скачивания