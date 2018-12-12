FROM envoyproxy/envoy:latest

RUN apt-get update && apt-get -q install -y curl
COPY booking-envoy.yaml /etc/booking-envoy.yaml
CMD /usr/local/bin/envoy -c /etc/booking-envoy.yaml --service-cluster service-booking