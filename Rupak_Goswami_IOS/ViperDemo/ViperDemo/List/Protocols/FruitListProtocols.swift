

import UIKit


protocol FruitListViewProtocol: AnyObject {
    // PRESENTER -> VIEW
    func showFruits(with fruits: [Fruit])
}

protocol FruitListPresenterProtocol: AnyObject {
    //View -> Presenter
    var interactor: FruitListInputInteractorProtocol? {get set}
    var view: FruitListViewProtocol? {get set}
    var wireframe: FruitListWireFrameProtocol? {get set}

    func viewDidLoad()
    func showFruitSelection(with fruit: Fruit, from view: UIViewController)
}

protocol FruitListInputInteractorProtocol: AnyObject {
    var presenter: FruitListOutputInteractorProtocol? {get set}
    //Presenter -> Interactor
    func getFruitList()
}

protocol FruitListOutputInteractorProtocol: AnyObject {
    //Interactor -> Presenter
    func fruitListDidFetch(fruitList: [Fruit])
}

protocol FruitListWireFrameProtocol: AnyObject {
    //Presenter -> Wireframe
    func pushToFruitDetail(with fruit: Fruit,from view: UIViewController)
    static func createFruitListModule(fruitListRef: FruitListView)
}
