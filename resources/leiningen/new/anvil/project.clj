(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "A barebones ClojureScript project"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :min-lein-version "2.7.1"

  :pedantic? :abort

  :dependencies [[org.clojure/clojure "1.10.1"]
                 [mount "0.1.16"]]

  :main ^:skip-aot {{name}}.core
  :target-path "target/%s"
  :source-paths ["src/clj" "src/cljs" "src/cljs/{{sanitized}}"]
  :resource-paths ["resources"]

  :aliases {"fig"       ["trampoline" "run" "-m" "figwheel.main"]
            "fig:dev"   ["trampoline" "run" "-m" "figwheel.main" "-b" "dev" "-r"]
            "fig:prod"  ["trampoline" "run" "-m" "figwheel.main" "-O" "advanced" "-bo" "prod"]
            "clj-kondo" ["trampoline" "run" "-m" "clj-kondo.main"]}

  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[com.bhauman/figwheel-main "0.2.11"
                                   :exclusions [org.clojure/java.classpath args4j commons-codec]]
                                  [com.bhauman/rebel-readline-cljs "0.1.4" :exclusions [args4j]]
                                  [cider/piggieback "0.5.1"]
                                  [org.clojure/clojurescript "1.10.773" :exclusions [com.google.code.findbugs/jsr305]]
                                  [ring/ring-devel "1.8.1" :exclusions [commons-codec]]
                                  [clj-kondo "RELEASE"]
                                  {{#reagent}}[reagent "0.10.0"]{{/reagent}}]
                   :source-paths ["env/dev/clj"]
                   :clean-targets ^{:protect false} ["target"]
                   :repl-options {:init-ns user
                                  :nrepl-middleware [cider.piggieback/wrap-cljs-repl]}}})
