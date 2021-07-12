# Abakasha_movies
The project basically have two screens, in first screen it shows the list of movies and in the second screen it shows the movie details.

Programing language - Kotlin

Libraries - Retrofit - for networking
          - Glide - for image loading and caching
          - Mockito - for mock web services
          - Dagger2 - for dependency injection

Architecture Components  - ViewModel
                         - LiveData
                         - Navigation
                         - View Binding

Project Architecture : Clean Architecture with MVVM also followed SOLID principle

There are 3 layers in the project
-data layer : This layer provides abstract definitions for accessing data sources like a database or the internet. In this case data source is only internet.

-domain layer : This layer contains all the model classes and business logic like GetMovieUseCase

-presentation layer : This layer contains the User Interface-related code. Here MVVM pattern is used.

Design Patterns Used: Singleton
                     -Factory
                     -Repository pattern

UnitTest : jUnit with Mockito is used for unit testing.
