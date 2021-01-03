# Change Log
All notable changes to this project will be documented in this file. This change log follows the conventions of [keepachangelog.com](http://keepachangelog.com/).

## Unreleased
### Added
- Option to compile for AWS lambda in a nodejs runtime
- Ability to use npm packages

## 0.3.2
### Fixed
- Confusing dependencies when pulling newest ClojureScript.

## 0.3.1 - 2020-12-20
### Fixed
- Corrected documentation how to run the figwheel development repl.
- Fixed issue when running with no options.

### Modified
- Upgraded dependencies.

## 0.2.4 - 2020-09-24
### Modified
- Upgraded dependencies.
- Added sample lein template section.

### Added
- Added linting support with clj-kondo.
- Reagent support.
- Re-Frame support. Only pulls the dependency for now, but there's no example on how to use it.

### Fixed
- Issue when running with `pedantic? :abort`.
- Fixed various linting errors.

## 0.2.3 - 2020-03-21
### Modified
- Upgraded dependencies.
- Clarified how to run with Docker.

## 0.2.1 - 2019-05-17
### Modified
- Added information about template options to readme.
### Added
- `.gitignore`

## 0.2.0 - 2019-04-09
### Added
- Support for project optional components. Only 1 option supported for now...
- Optional Docker support with +docker option.
- Added latest version badge.

## 0.1.0 - 2019-04-08
### Added
- Initial version
- Version is now 0.1.0. Removed SNAPSHOT for Clojars publication.
