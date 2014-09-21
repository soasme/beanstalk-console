(ns beanstalk-console.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [beanstalk-clj.core :as beanstalk]))


(defroutes app-routes

  ; API
  (context
   "/api" []
   (GET "/stats-job" []
        "{}")
   (GET "/stats-tube" []
        "{}")
   (GET "/stats-beanstalkd" []
        "{}")
   (GET "/list-tubes" []
        "[]"))

  ; Index Page
  (GET "/" [] "Hello World")
  (route/resources "/")

  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
