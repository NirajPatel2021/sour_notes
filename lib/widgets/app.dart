import 'package:flutter/material.dart';
import 'package:sour_notes/models/navigation_item.dart';
import 'package:sour_notes/pages/about_us_page.dart';
import 'package:sour_notes/pages/home_page.dart';
import 'package:sour_notes/pages/login.dart';
import 'package:sour_notes/pages/song_list.dart';

class App extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => AppState();
}

class AppState extends State<App> {
  int _currentPage = 0;

  final List<NavigationItem> _items = [
    NavigationItem(
        icon: const Icon(Icons.home),
        title: const Text("Home"),
        widget: HomePage(),
        NavigationItemKey: GlobalKey<NavigatorState>()),
    NavigationItem(
        icon: const Icon(Icons.person),
        title: const Text("Login"),
        widget: const MyCustomForm(),
        NavigationItemKey: GlobalKey<NavigatorState>()),
    NavigationItem(
        icon: const Icon(Icons.music_note),
        title: const Text("Music"),
        widget: SongListPage(),
        NavigationItemKey: GlobalKey<NavigatorState>()),
    NavigationItem(
        icon: const Icon(Icons.info),
        title: const Text("About Us"),
        widget: AboutUsPage(),
        NavigationItemKey: GlobalKey<NavigatorState>())
  ];

  Widget _navigationTab(
      {required GlobalKey<NavigatorState> naviKey, required Widget widget}) {
    return Navigator(
      key: naviKey,
      onGenerateRoute: (routeSettings) {
        return MaterialPageRoute(builder: (context) => widget);
      },
    );
  }

  void _selectTab(int index) {
    if (index == _currentPage) {
      _items[index]
          .NavigationItemKey
          .currentState
          ?.popUntil((route) => route.isFirst);
    } else {
      setState(() {
        _currentPage = index;
      });
    }
  }

  Widget _bottomNavigationBar() {
    return BottomNavigationBar(
      selectedItemColor: Colors.blueAccent,
      type: BottomNavigationBarType.fixed,
      currentIndex: _currentPage,
      onTap: (int index) {
        _selectTab(index);
      },
      items: _items
          .map((e) => BottomNavigationBarItem(icon: e.icon, title: e.title))
          .toList(),
    );
  }

  @override
  Widget build(BuildContext context) {
    return WillPopScope(
      onWillPop: () async {
        final isFirstRouteInCurrentTab = await _items[_currentPage]
            .NavigationItemKey
            .currentState!
            .maybePop();
        if (isFirstRouteInCurrentTab) {
          if (_currentPage != 0) {
            _selectTab(1);
            return false;
          }
        }
        // let system handle back button if we're on the first route
        return isFirstRouteInCurrentTab;
      },
      child: Scaffold(
        body: IndexedStack(
            index: _currentPage,
            children: _items
                .map((e) => _navigationTab(
                    naviKey: e.NavigationItemKey, widget: e.widget))
                .toList()),
        bottomNavigationBar: _bottomNavigationBar(),
      ),
    );
  }
}
