(ns beanstalk-console.handler
  (:use [ring.middleware params cookies]
        [ring.util.response])
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :as json-middleware]
            [beanstalk-clj.core :as beanstalk]))

(defn beanstalk-proxy [f config & rest]
  (let [client (beanstalk/beanstalkd-factory config)
        data (apply f client rest)]
    (response data)))

(defroutes app-routes

  ; API
  (context
   "/api" []
   (GET "/:config/stats-job/:jid" [config jid]
        (beanstalk-proxy beanstalk/stats-job config jid))
   (GET "/:config/stats-tube/:tube-name" [config tube-name]
        (beanstalk-proxy beanstalk/stats-tube config tube-name))
   (GET "/:config/stats" [config]
        (beanstalk-proxy beanstalk/stats-beanstalkd config))
   (GET "/:config/list-tubes" [config]
        (beanstalk-proxy beanstalk/list-tubes config)))

  ; Index Page
  (GET "/" [] "Hello World")
  (route/resources "/")

  (route/not-found "Not Found"))

(def app
  (-> (handler/site app-routes)
      (json-middleware/wrap-json-body)
      (json-middleware/wrap-json-response)))
