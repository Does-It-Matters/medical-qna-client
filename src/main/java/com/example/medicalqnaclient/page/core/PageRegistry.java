package com.example.medicalqnaclient.page.core;

import java.util.Map;

public interface PageRegistry {
    Map<PageType, Page> getPages();
}