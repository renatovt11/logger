package pe.logger.common.manager;

import pe.logger.common.constant.ErrorConstant;
import pe.logger.common.request.GlobalRequest;
import pe.logger.common.service.BaseAbstractService;
import pe.logger.configuration.exception.CustomException;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAbstractServicesManager<T extends BaseAbstractService> {

    protected abstract List<T> getServiceList();

    protected List<T> getSupportedServices(GlobalRequest toTest) {
        List<T> servicesList = new ArrayList<>();
        for (T service : getServiceList()) {
            if (!service.supports(toTest)) {
                continue;
            }
            servicesList.add(service);
        }
        return servicesList;
    }

    protected T getService(GlobalRequest toTest) {
        for (T service : getServiceList()) {
            if (!service.supports(toTest)) {
                continue;
            }
            return service;
        }
        throw new CustomException(ErrorConstant.NO_IMPLEMENTATION_SUPPORTED);
    }

}
