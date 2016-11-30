package io.github.kjens93.edmunds.services;

import io.github.kjens93.edmunds.promises.YearsPromise;

/**
 * Created by kjensen on 11/20/16.
 */
public interface YearsService extends YearService {

    YearsPromise findAllModelYears(String makeNiceName, String modelNiceName);

}
