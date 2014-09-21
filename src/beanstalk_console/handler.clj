(ns beanstalk-console.handler
  (:use [ring.middleware params cookies]
        [ring.util.response])
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :as json-middleware]
            [beanstalk-clj.core :as beanstalk]))

(defn stats-job [config jid]
  (let [client (beanstalk/beanstalkd-factory config)
        stats (beanstalk/stats-job client jid)]
    (response stats)))

(defn stats-server [config]
  (let [client (beanstalk/beanstalkd-factory config)
        stats (beanstalk/stats-beanstalkd client)]
    (response stats)))

(defn stats-tube [config tube-name]
  (let [client (beanstalk/beanstalkd-factory config)
        stats (beanstalk/stats-tube client tube-name)]
    (response stats)))

(defn list-tubes [config]
  (let [client (beanstalk/beanstalkd-factory config)
        tubes (beanstalk/list-tubes client)]
    (prn tubes)
    (response tubes)))

(defroutes app-routes

  ; API
  (context
   "/api" []
   (GET "/:config/stats-job/:jid" [config jid] (stats-job config jid))
   (GET "/:config/stats-tube/:tube-name" [config tube-name] (stats-tube config tube-name))
   (GET "/:config/stats" [config] (stats-server config))
   (GET "/:config/list-tubes" [config] (list-tubes config)))

  ; Index Page
  (GET "/" [] "Hello World")
  (route/resources "/")

  (route/not-found "Not Found"))

(def app
  (-> (handler/site app-routes)
      (json-middleware/wrap-json-body)
      (json-middleware/wrap-json-response)))
