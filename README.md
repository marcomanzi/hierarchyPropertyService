# Hierarchy Property Service

### Objective
Hierarchy Property System, this service will have the ability to define a Hierarchy of Objects. For example I can define this hierarchy:
* Root Level (the generic one)
    * Group Of User
        * User

A property set at Root Level will be the default for all the other sub objects, but if I override a property on SubUser level, that specific SubUser will have the value for Property Overriden.

Example for AB testing, you have a Commercial Web Site and you have implemented in your service a new cool Feature, called "I will get your Money for poor people", this feature will be activated if the property "robinHood" is set to true, the configuration will be:
* RootLevel -> robinHood: false
    * User(id: 12345) ->  robinHood: true
    
So all other services in your Architecture will call the API: 
* getPropertyForHierarchyObject [propertyKey, hierarchyName, hierachyObjectType, objectId] 
    * propertyKey: robinHood
    * hierachyObjectType: User
    * objectId: current User logged in the system

The service will reply with the right value.

I also have some Technical constrictions:
* Service should be a compatible Spring Cloud Service, the discovery server will be Zookeper
API definition should be done with Swagger 3, I can have it auto generated or I will first define it and then use it
* Test coverage near 100%, TDD will be preferrable but we will see
* I want to have other APIs:
    * createHierarchy [hierarchyName, & objectTypeWithLevel]
    * objectTypeWithLevel: is a structure with ObjectType name and level in the hierarchy
    * setPropertyOnHierarchy [propertyKey, value, hierarchyName, objectType]
