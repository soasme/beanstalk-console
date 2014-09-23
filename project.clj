(defproject beanstalk-console "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
                 [ring/ring-json "0.3.1"]
                 [beanstalk-clj "0.1.2"]
                 [org.clojure/clojurescript "0.0-2342"]]
  :plugins [[lein-ring "0.8.11"]
            [lein-bower "0.5.1"]
            [lein-cljsbuild "1.0.3"]]
  :ring {:handler beanstalk-console.handler/app}
  :bower-dependencies [[bootstrap "3.2.0"]
                       [jquery "2.1.1"]
                       [backbone "1.1.2"]]
  :bower {:directory "resources/public/js/lib"}
  :cljsbuild {
    :builds [{:source-paths ["src-cljs"]
              :compiler {:output-to "resources/public/dist/js/main.js",
                         :optimizations :whitespace
                         :pretty-print true}}]
  }
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
