# anvil

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

The purpose of this template is to getting you started with ClojureScript as soon as possible. As a result it doesn't have any features or optional libraries.

There are some aliases defined:

- `lein fig-dev` will start the fighweel REPL at `localhost:9500` but it won't start your browser by default. So you need to manually navigate to `localhost:9500` so that figwheel connects and the REPL is made available.
- `lein fig-prod` will compile the project with all optimizations turned on and generate a single JS file, suitable for production use.

### Development workflow

Running `lein fig-dev` starts the figwheel process. At that point figwheel will reload your code every time a change is made, and you can see it live in your browser. Neat!

However you may want to connect the REPL to your editor. In that case the way you proceed is different:

- First run a regular **Clojure REPL** (not ClojureScript) by issuing `lein repl :headless :port 6666`. The `:headless :port 6666` is not necessary, but if you omit it, leiningen will create a REPL prompt and use a random port.
- From your editor, connect to this Clojure REPL. In Emacs/Cider this is done by `cider-connect-clj` and enter `localhost` and `6666` when prompted for Host and Port, respectively.
- Once in the Clojure REPL evaluate `(start)` and it should start the figwheel process. Navigate to `localhost:9500`, it should connect and at that moment the **ClojureScript REPL** is available and connected to your editor. You can use `C-c C-c` to send forms for evaluation, etc. Also saving a file will cause figwheel to reload your code in the browser.

### Compiling

From the project directory:

```
lein fig-prod
```

It will generate JavaScript with all optimizations turned on. Output is written to `resources/public/cljs-out/prod-main.js`.

## Authors

* **César Olea** - *Initial work* - [Personal Homepage](https://blog.cesarolea.com)

## License

Copyright © 2019 César Olea

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
