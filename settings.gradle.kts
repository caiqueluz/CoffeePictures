pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }

        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CoffeePictures"
include(":app")
include(":infrastructure:network:api")
include(":infrastructure:network:impl")
include(":infrastructure:network:di")
include(":infrastructure:database:api")
include(":infrastructure:database:impl")
include(":infrastructure:database:di")
