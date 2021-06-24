package com.example.demo.Event.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;


/**
 * Created by Jakub krhovják on 6/24/21.
 */

@Data
@RequiredArgsConstructor
public class Event {

    private final String name;

    private final String data;
}
