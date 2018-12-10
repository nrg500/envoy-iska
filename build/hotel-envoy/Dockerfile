FROM envoyproxy/envoy:latest

RUN apt-get update && apt-get -q install -y curl
COPY hotel-envoy.yaml /etc/hotel-envoy.yaml
CMD /usr/local/bin/envoy -c /etc/hotel-envoy.yaml --service-cluster service-hotel