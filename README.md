<p align="center">
  <a href="https://github.com/ahdncordeiro/items/actions?query=workflow%3ATest" alt="Test">
      <img src="https://github.com/ahdncordeiro/items/workflows/Test/badge.svg?event=push" />
    </a>
</p>

# items
Run locally:
```
./gradlew bootRun --args='--spring.profiles.active=local'
```
Generate packages:
```
./gradlew clean javadocJar sourcesJar bootJar
```
