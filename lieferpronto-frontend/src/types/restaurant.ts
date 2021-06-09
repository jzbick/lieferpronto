export enum OrderStatus {
    ORDERED = 'ORDERED',
    IN_PROGRESS = 'IN_PROGRESS',
    IN_DELIVERY = 'IN_DELIVERY',
    DELIVERED = 'DELIVERED'
}

export enum PaymentMethod {
    CASHPAYMENT = 'CASHPAYMENT',
    DIRECTDEBIT = 'DIRECTDEBIT',
    CREDITCARD = 'CREDITCARD',
    PAYPAL = 'PAYPAL'
}

export enum DeliveryMethod {
    BICYCLE = 'BICYCLE',
    CAR = 'CAR',
    MOTORCYCLE = 'MOTORCYCLE'
}

interface Person {
    id: string
    phoneNumber: string
    email: string
    password: string
}

export interface Address {
    id: string
    street: string
    zip: string
    city: string
}

export interface Customer extends Person {
    firstname: string
    lastname: string
    addresses: Address[]
    orders: Order[]
}

export interface Deliveryman extends Person {
    deliveryMethod: DeliveryMethod
    address: Address
    orders: Order[]
}

export interface Order {
    id: string
    status: OrderStatus
    orderDate: Date
    deliveryDate: Date
    paymentMethod: PaymentMethod
    dishes: Dish[]
    restaurant: Restaurant
    customer: Customer
    deliveryman: Deliveryman
    address: Address
}

export interface Dish {
    id: string
    name: string
    price: string
}

export interface Restaurant {
    id: string;
    name: string;
    slug: string;
    email: string;
    password: string;
    minOrderValue: number;
    deliveryCosts: number;
    address: Address;
    dishes: Dish[];
}
