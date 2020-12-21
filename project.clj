(defproject anvil/lein-template "0.3.1"
  :description "A barebones leiningen template for ClojureScript with figwheel-main"
  :url "https://github.com/cesarolea/anvil-lein-template"
  :deploy-repositories [["clojars" {:url "https://clojars.org/repo"
                                    :username :env/clojars_username
                                    :password :env/clojars_password
                                    :sign-releases true}]]
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :eval-in-leiningen true)
