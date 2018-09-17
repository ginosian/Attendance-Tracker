package com.attendance_tracker.client.api;

import com.attendance_tracker.client.InfoResource;
import com.attendance_tracker.client.OwnerResource;

import java.io.Closeable;

/**
 * @author Marta Ginosyan<br/>
 * Date: gitsearcher<br/>
 * Date: 8/5/18<br/>
 */
public interface ApiClient  extends Closeable {

    InfoResource info();

    OwnerResource owner();

}
