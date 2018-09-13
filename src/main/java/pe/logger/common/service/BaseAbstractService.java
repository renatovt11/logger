package pe.logger.common.service;


import pe.logger.common.request.GlobalRequest;

public interface BaseAbstractService<R extends GlobalRequest> {

    boolean supports(R supportedClass);

}
