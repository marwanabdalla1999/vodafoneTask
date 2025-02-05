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

rootProject.name = "vodafoneTask"
include(":app")
include(":features")
include(":data")
include(":domain")
include(":core")
include(":features:forecast")
include(":features:inputcityfeature")
include(":core:base")
include(":core:network")
include(":core:navigations")
include(":data:services")
include(":data:repositories")
include(":domain:searchforweather")
