# anvil

[![Clojars Project](https://img.shields.io/clojars/v/anvil/lein-template.svg)](https://clojars.org/anvil/lein-template)

A leiningen template for a barebones ClojureScript project with figwheel-main.

## Getting Started

- Create a project with leiningen `lein new anvil my-project`
- `cd my-project`
- `lein fig-dev`
- Browse to `localhost:9500`

## Prerequisites

- Clojure
- leiningen

## Usage

The purpose of this template is to get you started with ClojureScript as soon as possible. As a result it has very few extra features or options beyond ClojureScript and Figwheel.

There are some aliases defined:

- `lein fig:dev` will start the fighweel REPL at `localhost:9500` but it won't start your browser by default. So you need to manually navigate to `localhost:9500` so that figwheel connects and the REPL is made available.
- `lein fig:prod` will compile the project with all optimizations turned on and generate a single JS file, suitable for production use.

### Options
- `+docker` generates a `Dockerfile` and suitable `docker-compose.yml` to run the project in a Docker container, while keeping the ability to connect to the REPL and a working Figwheel.
- `+reagent` adds reagent support and a small example of how to use it.
- `+reframe` pulls in the Re-Frame dependency and it will be ready to use in your own project, but there's no example (for now).

A project with all the options included in the template:

```
lein new my-anvil +docker +reagent +reframe
```

### Development workflow

Running `lein fig:dev` starts the figwheel process. At that point figwheel will reload your code every time a change is made, and you can see it live in your browser. Neat!

However you may want to connect the REPL to your editor. In that case the way you proceed is different:

#### Without Docker
- First run a regular **Clojure REPL** (not ClojureScript) by issuing `lein repl :headless :port 6666`. The `:headless :port 6666` is not necessary, but if you omit it, leiningen will create a REPL prompt and use a random port.
- From your editor, connect to this Clojure REPL. In Emacs/Cider this is done by `cider-connect-clj` and enter `localhost` and `6666` when prompted for Host and Port, respectively.
- Once in the Clojure REPL evaluate `(start)` and it should start the figwheel process. Navigate to `localhost:9500`, it should connect and at that moment the **ClojureScript REPL** is available and connected to your editor. You can use `C-c C-c` to send forms for evaluation, etc. Also saving a file will cause figwheel to reload your code in the browser.

#### With Docker
The workflow is very similar, the only difference is that the REPL will run inside the Docker container instead of your local computer. In order to start the REPL do `docker-compose up`. The container will start a REPL in port `6666`. Once the REPL is started, proceed as without Docker.

### Compiling

From the project directory:

```
lein fig:prod
```

It will generate JavaScript with all optimizations turned on. Output is written to `resources/public/cljs-out/prod-main.js`.

### Linting

Anvil comes with linting support thanks to `clj-kondo`. An alias is created for you; in order to run the linter with lein, you can do `lein clj-kondo --lint src`.

## Authors

* **César Olea** - *Initial work* - [Personal Homepage](https://blog.cesarolea.com)

## License

Copyright © 2020 César Olea

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
