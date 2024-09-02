module com.example.medicalqnaclient.utils {
    requires java.net.http;
    requires com.fasterxml.jackson.databind;

    exports com.example.medicalqnaclient.utils.format;
    exports com.example.medicalqnaclient.utils.network;
}