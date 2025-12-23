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
include(":infrastructure:image:api")
include(":infrastructure:image:impl")
include(":infrastructure:image:di")
include(":common:ui:api")
include(":common:ui:impl")
include(":common:ui:di")
include(":design-system")
include(":common:view-model")
include(":app-logic:api")
include(":app-logic:impl")
include(":app-logic:di")
